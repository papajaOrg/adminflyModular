package org.papaja.adminfly.module.psy.controller.test.mmpi2.sobchik;

import org.papaja.adminfly.module.psy.controller.test.mmpi2.MMPI2Controller;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI2Result;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI2SobchikResult;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI2_SOBCHIK;

@SuppressWarnings({"unused", "Duplicates"})
@Controller
@RequestMapping("/psy/MMPI2_SOBCHIK")
public class MMPI2SobchikController extends MMPI2Controller {

    @Autowired
    @Qualifier("wizardMMPI2")
    private Wizard<Answer> wizard;

    @Override
    public Wizard<Answer> getWizard() {
        return wizard;
    }

    @Override
    public Test getTest() {
        return MMPI2_SOBCHIK;
    }

    @Override
    protected MMPI2Result getMMPI2ResultEntity() {
        return new MMPI2SobchikResult();
    }

    @Controller
    @RequestMapping("/shared/psy/MMPI2_SOBCHIK")
    public static class Shared extends MMPI2Controller.MMPI2Shared {

        @Autowired
        @Qualifier("wizardMMPI2")
        private Wizard<Answer> wizard;

        {
            setPrefix("/psy/MMPI2_SOBCHIK/shared");
        }

        @Override
        public Wizard<Answer> getWizard() {
            return wizard;
        }

        @Override
        public Test getTest() {
            return MMPI2_SOBCHIK;
        }

    }

}