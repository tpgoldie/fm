package com.tpg.fm.pricing

import com.tpg.fm.TimeDependency
import com.tpg.fm.asset.{X, Y}
import com.tpg.fm.core.UnitsOf
import org.joda.time.DateTime

abstract class Price(X: X, Y: Y, val price: BigDecimal, t: DateTime) extends X with Y with TimeDependency {
  def *(that: Price): Option[Price]

  def *(that: UnitsOf): UnitsOf

  def inverse: Price
}
