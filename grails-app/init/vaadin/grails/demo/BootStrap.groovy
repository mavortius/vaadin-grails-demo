package vaadin.grails.demo

import groovy.util.logging.Slf4j

@Slf4j
class BootStrap {

    def init = { servletContext ->
        log.info 'Generating data...'

        final driver1 = new Driver(name: 'Susan', username: 'susan', password: 'password1').save()
        final driver2 = new Driver(name: 'Pedro', username: 'pedro', password: 'password2').save()

        final nissan = new Maker(name: 'Nissan').save()
        final ford = new Maker(name: 'Ford').save()

        final titan = new Model(name: 'Titan').save()
        final leaf = new Model(name: 'Leaf').save()
        final windstar = new Model(name: 'Windstar').save()

        new Vehicle(name: 'Pickup', driver: driver1, maker: nissan, model: titan).save()
        new Vehicle(name: 'Economy', driver: driver2, maker: nissan, model: leaf).save()
        new Vehicle(name: 'Minivan', driver: driver2, maker: ford, model: windstar).save()

        log.info 'Finished.'
    }

    def destroy = {
    }
}
