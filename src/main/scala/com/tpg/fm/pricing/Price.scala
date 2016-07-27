package com.tpg.fm.pricing

import com.tpg.fm.TimeDependency
import com.tpg.fm.asset.{X, Y}
import com.tpg.fm.core.Money.Zero
import com.tpg.fm.core.{Money, UnitsOf, UnitsOfX, UnitsOfY}
import org.joda.time.DateTime

abstract class Price(X: X, Y: Y, val price: BigDecimal, t: DateTime) extends X with Y with TimeDependency {
  def *(that: Price): Option[Price]

  def *(that: UnitsOfY): UnitsOfX = UnitsOfX(that.quantity * price, X)

  def numeraire: Y = Y

  def inverse: Price
}

abstract class PositivePrice(X: X, Y: Y, price: BigDecimal, t: DateTime) extends Price(X, Y, price.abs, t) {
}

abstract class NegativePrice(X: X, Y: Y, price: BigDecimal, t: DateTime) extends Price(X, Y, -(price.abs), t) {
}

abstract class ZeroPrice(X: X, Y: Y, t: DateTime) extends Price(X, Y, Zero, t)
