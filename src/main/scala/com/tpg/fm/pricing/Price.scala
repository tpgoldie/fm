package com.tpg.fm.pricing

import com.tpg.fm.asset.{X, Y}
import org.joda.time.DateTime

abstract class Price(X: X, Y: Y, val price: BigDecimal, t: DateTime) extends X with Y {
  def inverse: Price
}
