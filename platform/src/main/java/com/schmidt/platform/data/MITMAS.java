/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.data;

import javax.persistence.Table;
import javax.persistence.Index;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013��10��8��
 */
@Table(
		indexes = {
				@Index(name = "a", columnList = "aaa, aaaa, b", unique = true)
		}
)
public class MITMAS {

}
