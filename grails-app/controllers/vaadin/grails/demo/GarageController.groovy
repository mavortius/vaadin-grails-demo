package vaadin.grails.demo

import grails.converters.JSON
import groovy.transform.CompileStatic

@CompileStatic
class GarageController {

    VehicleService vehicleService

    def index() {
        final List<Vehicle> vehicleList = vehicleService.listAll()

        render vehicleList as JSON
    }
}
