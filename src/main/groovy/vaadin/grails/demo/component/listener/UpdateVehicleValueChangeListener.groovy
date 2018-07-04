package vaadin.grails.demo.component.listener

import com.vaadin.data.HasValue
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import vaadin.grails.demo.Vehicle
import vaadin.grails.demo.component.VehicleEventType

@Slf4j
@CompileStatic
class UpdateVehicleValueChangeListener extends AbstractVehicleListener implements HasValue.ValueChangeListener {

    UpdateVehicleValueChangeListener(VehicleEventType eventType, Vehicle vehicle) {
        super(eventType, vehicle)
    }

    @Override
    void valueChange(HasValue.ValueChangeEvent event) {
        updateVehicle(eventType, event.value)
    }
}
