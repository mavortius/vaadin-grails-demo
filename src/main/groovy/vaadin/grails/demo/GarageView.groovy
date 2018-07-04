package vaadin.grails.demo

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import vaadin.grails.demo.component.ComponentFactory
import vaadin.grails.demo.component.GarageItemCaptionGenerator
import vaadin.grails.demo.component.VehicleEventType
import vaadin.grails.demo.component.listener.UpdateVehicleComboBoxSelectionListener
import vaadin.grails.demo.component.listener.UpdateVehicleValueChangeListener
import vaadin.grails.demo.component.provider.VehicleValueProvider

import javax.annotation.PostConstruct

@CompileStatic
@SpringView(name = GarageView.VIEW_NAME)
class GarageView extends VerticalLayout implements View {
    public static final String VIEW_NAME = ""

    private static final String DEFAULT_WIDTH = '100%'

    @Autowired
    private DriverService driverService

    @Autowired
    private MakerService makerService

    @Autowired
    private ModelService modelService

    @Autowired
    private VehicleService vehicleService

    private Vehicle vehicle = new Vehicle()

    @PostConstruct
    void init() {
        final HorizontalLayout titleRow = new HorizontalLayout()
        titleRow.width = DEFAULT_WIDTH
        addComponent(titleRow)

        final Label title = new Label('Add a vehicle:')
        titleRow.addComponent(title)
        titleRow.setExpandRatio(title, 1.0f)

        final HorizontalLayout inputRow = new HorizontalLayout()
        inputRow.width = DEFAULT_WIDTH
        addComponent(inputRow)

        final TextField vehicleName = ComponentFactory.createTextField('Enter a name...')
        final ComboBox<Maker> vehicleMaker = ComponentFactory.createComboBox(makerService.listAll(), 'Select a maker')
        final ComboBox<Model> vehicleModel = ComponentFactory.createComboBox(modelService.listAll(), 'Select a model')
        final ComboBox<Driver> vehicleDriver = ComponentFactory.createComboBox(driverService.listAll(), 'Select a driver')
        final Button submitButton = ComponentFactory.createButton('Add to Garage', ValoTheme.BUTTON_FRIENDLY)

        vehicleName.addValueChangeListener(new UpdateVehicleValueChangeListener(VehicleEventType.NAME, vehicle))
        vehicleMaker.addSelectionListener(new UpdateVehicleComboBoxSelectionListener(VehicleEventType.MAKER, vehicle))
        vehicleModel.addSelectionListener(new UpdateVehicleComboBoxSelectionListener(VehicleEventType.MODEL, vehicle))
        vehicleDriver.addSelectionListener(new UpdateVehicleComboBoxSelectionListener(VehicleEventType.DRIVER, vehicle))

        submitButton.addClickListener { event -> submit() }

        [vehicleName, vehicleMaker, vehicleModel, vehicleDriver, submitButton].each {
            inputRow.addComponent it
        }

        final HorizontalLayout dataDisplayRow = new HorizontalLayout()
        dataDisplayRow.width = DEFAULT_WIDTH
        dataDisplayRow.addComponent(buildVehicleComponent())
        addComponent(dataDisplayRow)
    }

    private Grid buildVehicleComponent() {
        final List<Vehicle> vehicles = vehicleService.listAll(false)
        final Grid grid = new Grid<>()

        grid.with {
            setSizeFull()
            items = vehicles
            addColumn(new VehicleValueProvider(VehicleValueProvider.ID)).caption = 'ID'
            addColumn(new VehicleValueProvider(VehicleValueProvider.NAME)).caption = 'Name'
            addColumn(new VehicleValueProvider(VehicleValueProvider.MAKER_NAME)).caption = 'Maker'
            addColumn(new VehicleValueProvider(VehicleValueProvider.MODEL_NAME)).caption = 'Model'
            addColumn(new VehicleValueProvider(VehicleValueProvider.DRIVER_NAME)).caption = 'Driver'
        }
        grid
    }

    private submit() {
        vehicleService.save vehicle
        getUI().navigator.navigateTo VIEW_NAME
    }

    @Override
    void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
