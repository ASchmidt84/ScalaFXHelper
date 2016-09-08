/*
 * Copyright (c) 2016. All rights reserved.
 *
 * Redistribution and use of Software by Intelligy Science UG (haftungsbeschränkt) in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * Neither the name of Intelligy Science UG (haftungsbeschränkt) nor the names or the software authors or contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS, AUTHORS, AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL INTELLIGY SCIENCE UG (HAFTUNGSBESCHRÄNKT) OR ANY AUTHORS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This product can includes software developed by the Apache Software Foundation
 * <http://www.apache.org/>.
 */

package ui;

import com.sun.javafx.css.converters.SizeConverter;
import javafx.beans.property.DoubleProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableDoubleProperty;
import javafx.css.StyleableProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Progress indicator showing a filling arc.
 *
 * @author Andrea Vacondio
 * https://github.com/torakiki/fx-progress-circle
 *
 */
public class RingProgressIndicator extends ProgressCircleIndicator {
    public RingProgressIndicator() {
        this.getStylesheets().add(RingProgressIndicator.class.getResource("/ringprogress.css").toExternalForm());
        this.getStyleClass().add("ringindicator");
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new RingProgressIndicatorSkin(this);
    }

    public final void setRingWidth(int value) {
        ringWidthProperty().set(value);
    }

    public final DoubleProperty ringWidthProperty() {
        return ringWidth;
    }

    public final double getRingWidth() {
        return ringWidthProperty().get();
    }

    /**
     * thickness of the ring indicator.
     */
    private DoubleProperty ringWidth = new StyleableDoubleProperty(22) {
        @Override
        public Object getBean() {
            return RingProgressIndicator.this;
        }

        @Override
        public String getName() {
            return "ringWidth";
        }

        @Override
        public CssMetaData<RingProgressIndicator, Number> getCssMetaData() {
            return StyleableProperties.RING_WIDTH;
        }
    };

    private static class StyleableProperties {
        private static final CssMetaData<RingProgressIndicator, Number> RING_WIDTH = new CssMetaData<RingProgressIndicator, Number>(
                "-fx-ring-width", SizeConverter.getInstance(), 22) {

            @Override
            public boolean isSettable(RingProgressIndicator n) {
                return n.ringWidth == null || !n.ringWidth.isBound();
            }

            @Override
            public StyleableProperty<Number> getStyleableProperty(RingProgressIndicator n) {
                return (StyleableProperty<Number>) n.ringWidth;
            }
        };

        public static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<>(Control.getClassCssMetaData());
            styleables.addAll(ProgressCircleIndicator.getClassCssMetaData());
            styleables.add(RING_WIDTH);
            STYLEABLES = Collections.unmodifiableList(styleables);
        }
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }
}