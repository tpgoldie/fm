package com.tpg.fm.forex

import com.tpg.fm.core.Currency
import com.tpg.fm.core.Money.One
import com.tpg.fm.pricing.{PositivePrice, Price}
import org.joda.time.DateTime

case class ExchangeRate(X: Currency, Y: Currency, override val price: BigDecimal, t: DateTime = new DateTime()) extends PositivePrice(X, Y, price, t) {
  override def inverse: Price = ExchangeRate(Y, X, One / price, t)

  override def *(that: Price): Option[Price] = {
    if (that.isInstanceOf[ExchangeRate]) {
      val rate1 = this
      val rate2 = that.asInstanceOf[ExchangeRate]

      if ((rate1.t == rate2.t) && (rate1.Y == rate2.X)) {
        Option(ExchangeRate(rate1.X, rate2.Y, rate1.price * rate2.price, t))
      }
      else { None }
    }
    else { None }
  }
}

object ExchangeRate {
  type CurrencyPair = (Currency, Currency)
}