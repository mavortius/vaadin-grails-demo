package vaadin.grails.demo

import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.navigator.ViewDisplay
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.spring.annotation.SpringViewDisplay
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Component
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.Notification
import com.vaadin.ui.Panel
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme
import groovy.transform.CompileStatic

@CompileStatic
@SpringUI(path="/ui")
@SpringViewDisplay
@Title('Vaadin Grails')
@Theme(ValoTheme.THEME_NAME)
class AppUI extends UI implements ViewDisplay {
    private Panel viewDisplay

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout()
        content = root
        viewDisplay = new Panel()
        viewDisplay.setSizeFull()

        root.with {
            setSizeFull()
            addComponent(buildHeader())
            addComponent(viewDisplay)
            setExpandRatio(viewDisplay, 1.0f)
        }
    }

    private static Label buildHeader() {
        new Label('Welcome to the Garage')
    }

    @Override
    void showView(View view) {
        viewDisplay.content = view as Component
    }
}
