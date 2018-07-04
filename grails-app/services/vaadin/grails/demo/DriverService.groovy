package vaadin.grails.demo

import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileStatic

@CompileStatic
@ReadOnly
class DriverService {

    @ReadOnly
    List<Driver> listAll() {
        Driver.where {}.list()
    }
}
