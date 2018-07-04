package vaadin.grails.demo.component.listener

import com.vaadin.event.selection.SingleSelectionEvent
import com.vaadin.event.selection.SingleSelectionListener
import groovy.transform.CompileStatic
import vaadin.grails.demo.Vehicle
import vaadin.grails.demo.component.VehicleEventType

@CompileStatic
class UpdateVehicleComboBoxSelectionListener extends AbstractVehicleListener implements SingleSelectionListener {

    UpdateVehicleComboBoxSelectionListener(VehicleEventType eventType, Vehicle vehicle) {
        super(eventType, vehicle)
    }

    @Override
    void selectionChange(SingleSelectionEvent event) {
        updateVehicle(eventType, event.firstSelectedItem)
    }
}
