package vaadin.grails.demo

import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileStatic

@CompileStatic
@ReadOnly
class VehicleService {

    def save(final Vehicle vehicle) {
        vehicle.save(failOnError: true)
    }

    @ReadOnly
    List<Vehicle> listAll(boolean lazyFetch = true) {
        if (!lazyFetch) {
            Vehicle.where {}
                    .join('maker')
                    .join('model')
                    .join('driver')
                    .list()
        } else {
            Vehicle.where {}.list()
        }
    }
}
