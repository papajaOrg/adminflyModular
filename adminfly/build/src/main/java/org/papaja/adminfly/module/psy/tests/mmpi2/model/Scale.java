package org.papaja.adminfly.module.psy.tests.mmpi2.model;

import static java.lang.Math.round;

public enum Scale {

    SCALE_A("?"),
    SCALE_L("L"),
    SCALE_F("F"),
    SCALE_K("K"),
    SCALE_1("Hs", K.HP),
    SCALE_2("D"),
    SCALE_3("Hy"),
    SCALE_4("Pd", K.QP),
    SCALE_5_F("Mf-F", true),
    SCALE_5_M("Mf-M", true),
    SCALE_6("Pa"),
    SCALE_7("Pt", K.OP),
    SCALE_8("Sc", K.OP),
    SCALE_9("Ma", K.FP),
    SCALE_0("Si");

    private K k;
    private boolean inverted;
    private String  name;

    Scale(String name, K k, boolean inverted) {
        this.name = name;
        this.k = k;
        this.inverted = inverted;
    }

    Scale(String name, K k) {
        this(name, k, false);
    }

    Scale(String name, boolean inverted) {
        this(name, null, inverted);
    }

    Scale(String name) {
        this(name, null, false);
    }

    public boolean hasK() {
        return k != null;
    }

    public K getK() {
        return k;
    }

    public boolean isInverted() {
        return inverted;
    }

    public String getName() {
        return name;
    }

    public enum K {

        HP(0.5f),
        QP(0.4f),
        FP(0.2f),
        OP(1.0f);

        private float factor;

        K(float factor) {
            this.factor = factor;
        }

        public int calculate(float rate) {
            return round(rate / (120 / (30 * factor)));
        }

    }

}