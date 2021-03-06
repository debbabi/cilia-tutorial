/*
 * JORAM: Java(TM) Open Reliable Asynchronous Messaging
 * Copyright (C) 2001 - ScalAgent Distributed Technologies
 * Copyright (C) 1996 - Dyade
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA.
 *
 * Initial developer(s): Frederic Maistre (INRIA)
 * Contributor(s):
 */
package dotcom;

/**
 * An OrderMessage contains an order. 
 *
 * @author	Maistre Frederic
 * 
 * @see		WebOrdering
 * @see		CustomerTreatment
 * @see		InventoryTreatment
 * @see		BillingTreatment
 * @see		ControlTreatment
 * @see		DeliveryTreatment
 */
public class OrderMessage implements java.io.Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /** Order id. */
  int id ;
  /** Item ordered. */
  String item ;
  /** Result of InventoryServer's treatement: true if validated, false otherwise. */
  boolean inventoryOK ;
  /** Result of ControlServer's treatement: true if validated, false otherwise. */
  boolean billingOK ;
  
  /**
   * Creates an OrderMessage.
   *
   * @param id			order id
   * @param choice		item
   */
  OrderMessage (int id, String choice) {
     this.id = id ;
     this.item = choice ;
     inventoryOK = false ;
     billingOK = false ;
  }
}
