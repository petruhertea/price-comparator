package com.petruth.price_comparator_market.util;

import com.petruth.price_comparator_market.dao.PriceAlertRepository;
import com.petruth.price_comparator_market.entity.PriceAlert;
import com.petruth.price_comparator_market.service.PriceAlertServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceAlertServiceImplTest {

    @Test
    void testCheckAlertsShouldReturnMatchingAlerts() {
        PriceAlertRepository mockRepo = mock(PriceAlertRepository.class);
        PriceAlertServiceImpl service = new PriceAlertServiceImpl(mockRepo);

        PriceAlert alert = new PriceAlert();
        alert.setTargetPrice(5.0);
        alert.setActive(true);

        when(mockRepo.findByProductIdAndIsActiveTrue("123")).thenReturn(List.of(alert));

        List<PriceAlert> alerts = service.checkAlerts("123", 4.5);

        assertEquals(1, alerts.size());
    }
}
