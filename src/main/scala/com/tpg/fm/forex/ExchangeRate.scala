package com.tpg.fm.forex

import com.tpg.fm.core.Money
import com.tpg.fm.core.Money.One
import com.tpg.fm.pricing.Price
import org.joda.time.DateTime

case class ExchangeRate(X: Money, Y: Money, override val price: BigDecimal, t: DateTime = new DateTime()) extends Price(X, Y, price, t) {
  override def inverse: Price = ExchangeRate(Y, X, One / price, t)
}
