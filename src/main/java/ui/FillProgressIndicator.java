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

/**
 * Created by andre on 08.09.16.
 */
import javafx.scene.control.Skin;

/**
 * Progress indicator showing a circle that fills
 *
 * @author Andrea Vacondio
 * https://github.com/torakiki/fx-progress-circle
 *
 */
public class FillProgressIndicator extends ProgressCircleIndicator {

    public FillProgressIndicator() {
        this.getStylesheets().add(RingProgressIndicator.class.getResource("/fillprogress.css").toExternalForm());
        this.getStyleClass().add("fillindicator");
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new FillProgressIndicatorSkin(this);
    }
}