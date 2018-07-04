package vaadin.grails.demo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MakerSpec extends Specification implements DomainUnitTest<Maker> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
