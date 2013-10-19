/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.aw01.test;

import javax.enterprise.context.RequestScoped;

import com.schmidt.himalia.workflow.AbstractState;
import com.schmidt.himalia.workflow.Provider;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013Äê10ÔÂ11ÈÕ
 */
@RequestScoped
@Provider(type="gr", id="qc")
public class DemoState extends AbstractState {

}
