package vaadin.grails.demo

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = ['name', 'maker', 'model'])
@ToString(includes = ['name', 'maker', 'model'], includeNames = true, includePackage = false)
class Vehicle {

    String name
    Maker maker
    Model model

    static belongsTo = [driver: Driver]

    static constraints = {
        name nullable: false
    }
}
