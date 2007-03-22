/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.jms;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultExchange;

import javax.jms.Message;

/**
 * Represents an {@ilnk Exchange} for working with JMS
 *
 * @version $Revision:520964 $
 */
public class JmsExchange extends DefaultExchange {
    private JmsBinding binding;

    public JmsExchange(CamelContext context, JmsBinding binding) {
        super(context);
        this.binding = binding;
    }

    public JmsExchange(CamelContext context, JmsBinding binding, Message message) {
        this(context, binding);
        setIn(new JmsMessage(message));
    }

    @Override
    public JmsMessage getIn() {
        return (JmsMessage) super.getIn();
    }

    @Override
    public JmsMessage getOut() {
        return (JmsMessage) super.getOut();
    }

    @Override
    public JmsMessage getFault() {
        return (JmsMessage) super.getFault();
    }

    public JmsBinding getBinding() {
        return binding;
    }

    @Override
    public Exchange newInstance() {
        return new JmsExchange(getContext(), binding);
    }

    @Override
    protected JmsMessage createInMessage() {
        return new JmsMessage();
    }

    @Override
    protected JmsMessage createOutMessage() {
        return new JmsMessage();
    }
}
