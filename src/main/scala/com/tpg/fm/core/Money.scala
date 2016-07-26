package com.tpg.fm.core

import com.tpg.fm.asset.{Y, X}
import com.tpg.fm.core.Money.One
import org.joda.time.DateTime

case class Money(currency: Currency, amount: BigDecimal = One, t: DateTime = new DateTime()) extends X with Y {
  override def X = this
  override def Y = this
}

object Money {
  val One = BigDecimal("1.000000")
}
