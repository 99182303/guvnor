/*
 * Copyright 2011 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.guvnor.client.widgets.drools.decoratedgrid.events;

import java.util.List;

import org.drools.guvnor.client.widgets.drools.decoratedgrid.CellValue;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * An event to update a columns content
 */
public class UpdateColumnEvent extends GwtEvent<UpdateColumnEvent.Handler> {

    public static interface Handler
        extends
        EventHandler {

        void onUpdateColumn(UpdateColumnEvent event);

    }

    public static Type<UpdateColumnEvent.Handler>       TYPE = new Type<UpdateColumnEvent.Handler>();

    private final int                                   index;
    private List<CellValue< ? extends Comparable< ? >>> columnData;

    public UpdateColumnEvent(int index,
                             List<CellValue< ? extends Comparable< ? >>> columnData) {
        this.index = index;
        this.columnData = columnData;
    }

    public int getIndex() {
        return this.index;
    }

    public List<CellValue< ? extends Comparable< ? >>> getColumnData() {
        return this.columnData;
    }

    @Override
    public Type<UpdateColumnEvent.Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(UpdateColumnEvent.Handler handler) {
        handler.onUpdateColumn( this );
    }

}
