/*
 * Copyright 2014-15 Skynav, Inc. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY SKYNAV, INC. AND ITS CONTRIBUTORS “AS IS” AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL SKYNAV, INC. OR ITS CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.skynav.ttpe.layout;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;

import com.skynav.ttv.app.OptionSpecification;
import com.skynav.ttx.transformer.TransformerContext;
import com.skynav.ttx.transformer.TransformerOptions;

import com.skynav.ttpe.area.Area;

public abstract class LayoutProcessor implements TransformerOptions, DocumentLayout {

    protected LayoutProcessor() {
    }

    public Collection<OptionSpecification> getShortOptionSpecs() {
        return new java.util.ArrayList<OptionSpecification>();
    }

    public Collection<OptionSpecification> getLongOptionSpecs() {
        return new java.util.ArrayList<OptionSpecification>();
    }

    public int parseLongOption(String args[], int index) {
        return index;
    }

    public int parseShortOption(String args[], int index) {
        return index;
    }

    public void processDerivedOptions() {
    }

    public abstract String getName();

    public abstract List<Area> layout(Document d, TransformerContext context);

    public static LayoutProcessor getDefaultProcessor() {
        return BasicLayoutProcessor.PROCESSOR;
    }

    private static Map<String,LayoutProcessor> processorMap;

    static {
        processorMap = new java.util.TreeMap<String,LayoutProcessor>();
        processorMap.put(BasicLayoutProcessor.PROCESSOR.getName(), BasicLayoutProcessor.PROCESSOR);
    }

    public static Set<String> getProcessorNames() {
        return processorMap.keySet();
    }

    public static LayoutProcessor getProcessor(String name) {
        return processorMap.get(name);
    }

}