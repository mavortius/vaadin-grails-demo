package vaadin.grails.demo.component

import com.vaadin.ui.ItemCaptionGenerator
import groovy.transform.CompileStatic
import vaadin.grails.demo.Driver
import vaadin.grails.demo.Maker
import vaadin.grails.demo.Model

@CompileStatic
class GarageItemCaptionGenerator implements ItemCaptionGenerator {

    @Override
    String apply(Object item) {
        switch (item) {
            case Maker:
                return (item as Maker).name
            case Driver:
                return (item as Driver).name
            case Model:
                return (item as Model).name
            default:
                return null
        }
    }
}
