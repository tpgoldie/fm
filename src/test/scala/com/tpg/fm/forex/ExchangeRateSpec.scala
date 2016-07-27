package com.tpg.fm.forex

import com.tpg.fm.core._
import org.joda.time.DateTime
import org.scalatest.{Matchers, FlatSpec}

class ExchangeRateSpec extends FlatSpec with Matchers {
  val now = new DateTime()

  "exchange rate" should "have an inverse rate" in {
    val rate = ExchangeRate(EURO, USD, BigDecimal("1.4415"), now)

    val actual = rate.inverse

    actual should have(
      'X(USD),
      'Y(EURO),
      't(now)
    )

    actual.price should be(BigDecimal("0.6937") +- 1e-4)
  }

  it should "have equality defined as same X, Y, price and t" in {
    val rate1 = ExchangeRate(EURO, USD, BigDecimal("1.4415"), now)

    val rate2 = ExchangeRate(EURO, USD, BigDecimal("1.4415"), now)

    rate1 == rate2 should be (true)
  }

  it should "multiply with another exchange rate of the same t" in {
    val rate1 = ExchangeRate(USD, GBP, BigDecimal("0.6238"), now)

    val rate2 = ExchangeRate(GBP, EURO, BigDecimal("1.1122"), now)

    val actual = (rate1 * rate2).get

    actual should have(
      'X(USD),
      'Y(EURO),
      't(now)
    )

    actual.price should be(BigDecimal("0.6937") +- 1e-4)
  }

  it should "multiply with units of" in {
    val rate = ExchangeRate(USD, GBP, BigDecimal("0.6238"), now)

    val actual = rate * UnitsOfY(100, GBP)

    actual should have(
      'asset(USD)
    )

    actual.quantity should be(BigDecimal((100.0 * 0.6238).toString) +- 1e-4)
  }

  "two exchange rates" should "not be the same if they have the different Xs but the same Y, price and t" in {
    val rate1 = ExchangeRate(EURO, USD, BigDecimal("1.4415"), now)

    val rate2 = ExchangeRate(GBP, USD, BigDecimal("1.4415"), now)

    rate1 == rate2 should be (false)
  }

  "two exchange rates" should "not be the same if they have the different Ys but the same X, price and t" in {
    val rate1 = ExchangeRate(EURO, USD, BigDecimal("1.4415"), now)

    val rate2 = ExchangeRate(EURO, GBP, BigDecimal("1.4415"), now)

    rate1 == rate2 should be (false)
  }

  "two exchange rates" should "not be the same if they have the different prices but the same X, Y and t" in {
    val rate1 = ExchangeRate(EURO, USD, BigDecimal("1.4415"), now)

    val rate2 = ExchangeRate(EURO, GBP, BigDecimal("1.4425"), now)

    rate1 == rate2 should be (false)
  }

  "two exchange rates" should "not be the same if they have the different ts but the same X, Y and price" in {
    val rate1 = ExchangeRate(EURO, GBP, BigDecimal("1.4415"), now.minus(1000))

    val rate2 = ExchangeRate(EURO, GBP,  BigDecimal("1.4425"), now)

    rate1 == rate2 should be (false)
  }
}
