package vaadin.grails.demo.component.listener

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import vaadin.grails.demo.Driver
import vaadin.grails.demo.Maker
import vaadin.grails.demo.Model
import vaadin.grails.demo.Vehicle
import vaadin.grails.demo.component.VehicleEventType

@Slf4j
@CompileStatic
abstract class AbstractVehicleListener {
    protected VehicleEventType eventType
    protected Vehicle vehicle

    AbstractVehicleListener(VehicleEventType eventType, Vehicle vehicle) {
        this.eventType = eventType
        this.vehicle = vehicle
    }

    protected void updateVehicle(final VehicleEventType eventType, final eventValue) {
        switch (eventType) {
            case VehicleEventType.NAME:
                if (eventValue instanceof String) {
                    vehicle.name = eventValue as String
                }
                break
            case VehicleEventType.MAKER:
                if (eventValue instanceof Optional<Maker>) {
                    vehicle.maker = (eventValue as Optional<Maker>).get()
                }
                break
            case VehicleEventType.MODEL:
                if (eventValue instanceof Optional<Model>) {
                    vehicle.model = (eventValue as Optional<Model>).get()
                }
                break
            case VehicleEventType.DRIVER:
                if (eventValue instanceof Optional<Driver>) {
                    vehicle.driver = (eventValue as Optional<Driver>).get()
                }
                break
            default:
                log.error 'updateVehicle invoked with wrong eventType: {}', eventType
        }
    }
}
