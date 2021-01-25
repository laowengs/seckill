package com.laowengs.seckill.core.log;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class CommonLogTest {
    private final static Logger logger = LoggerFactory.getLogger(CommonLogTest.class);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testLog() {
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.debug("debug");
    }
}