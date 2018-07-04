package vaadin.grails.demo

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = ['name'])
@ToString(includes = ['name'], includeNames = true, includePackage = false)
class Maker {

    String name

    static constraints = {
        name nullable: false
    }
}
