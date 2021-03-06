/*
 * Copyright (c) 2002-2018 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.cypher.internal.runtime.interpreted

import java.util.Comparator

import org.neo4j.cypher.internal.v3_4.logical.plans.MinMaxOrdering
import org.neo4j.kernel.impl.api.PropertyValueComparison

object CypherOrdering {

  import MinMaxOrdering._

  val DEFAULT = Ordering.comparatorToOrdering(PropertyValueComparison.COMPARE_VALUES.asInstanceOf[Comparator[Any]]).withNullsLast

  val BY_VALUE = MinMaxOrdering(Ordering.comparatorToOrdering(PropertyValueComparison.COMPARE_VALUES.asInstanceOf[Comparator[Any]]))
  val BY_NUMBER = MinMaxOrdering(Ordering.comparatorToOrdering(PropertyValueComparison.COMPARE_NUMBERS))
  val BY_STRING = MinMaxOrdering(Ordering.comparatorToOrdering(PropertyValueComparison.COMPARE_STRINGS))
  val BY_POINT = MinMaxOrdering(Ordering.comparatorToOrdering(PropertyValueComparison.COMPARE_POINTS))
  val BY_DATE = MinMaxOrdering(Ordering.comparatorToOrdering(PropertyValueComparison.COMPARE_DATES))
}

