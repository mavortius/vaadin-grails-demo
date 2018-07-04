package vaadin.grails.demo

import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileStatic

@CompileStatic
class MakerService {

    @ReadOnly
    List<Maker> listAll() {
        Maker.where {}.list()
    }
}
