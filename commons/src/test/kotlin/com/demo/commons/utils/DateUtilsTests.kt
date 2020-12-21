package com.demo.commons.utils

import kotlin.test.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDate

class DateUtilsTests {

    protected val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Test
    fun testMonth(){
        val month = DateUtils.currentMonth()
        logger.debug("month=$month")
    }

    @Test
    fun testYear(){
        val year = DateUtils.currentYear()
        logger.debug("year=$year")
    }

    @Test
    fun test_dateToString(){
        val date = LocalDate.now()
        val dateString = DateUtils.dateToString(date, "yyyy-MM-dd")
        logger.debug("today is: $dateString")

        val futureDate = date.plusMonths(6)
        val dateInHalfYear = DateUtils.dateToString(futureDate, "yyyy-MM-dd")
        logger.debug("after 6 month, date is: $dateInHalfYear")
    }

}