package org.sergei.topten;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergei Visotsky
 */
public class TopTenWinningsServiceImplTest {

    private final TopTenWinningsService service = new TopTenWinningsServiceImpl();

    @Test
    public void shouldReportWinning() {
        Winning firstWinning = new Winning();
        firstWinning.setUserId(1L);
        firstWinning.setAmount(BigDecimal.valueOf(100));

        Winning secondWinning = new Winning();
        secondWinning.setUserId(2L);
        secondWinning.setAmount(BigDecimal.valueOf(1_000));

        Winning thirdWinning = new Winning();
        thirdWinning.setUserId(3L);
        thirdWinning.setAmount(BigDecimal.valueOf(10_000));

        service.reportWinnings(firstWinning);
        service.reportWinnings(secondWinning);
        service.reportWinnings(thirdWinning);

        assertEquals(3, service.getWinningsCount());
        assertEquals(BigDecimal.valueOf(100), service.getWinnings().get(0).getAmount());
        assertEquals(BigDecimal.valueOf(1_000), service.getWinnings().get(1).getAmount());
        assertEquals(BigDecimal.valueOf(10_000), service.getWinnings().get(2).getAmount());
    }

    @Test
    public void shouldGetTopTenWinningsDesc() {
        Winning firstWinning = new Winning();
        firstWinning.setUserId(1L);
        firstWinning.setAmount(BigDecimal.valueOf(100));

        Winning secondWinning = new Winning();
        secondWinning.setUserId(2L);
        secondWinning.setAmount(BigDecimal.valueOf(1_000));

        Winning thirdWinning = new Winning();
        thirdWinning.setUserId(3L);
        thirdWinning.setAmount(BigDecimal.valueOf(10_000));

        long userId = 1L;
        for (int i = 1; i < 200_000_000; i++) {
            service.reportWinnings(new Winning(userId, BigDecimal.valueOf(i)));
        }

        List<Winning> winnings = service.getTopTenWinningsDesc();
        assertEquals(BigDecimal.valueOf(19), winnings.get(0).getAmount());
        assertEquals(BigDecimal.valueOf(18), winnings.get(1).getAmount());
        assertEquals(BigDecimal.valueOf(17), winnings.get(2).getAmount());
        assertEquals(BigDecimal.valueOf(16), winnings.get(3).getAmount());
        assertEquals(BigDecimal.valueOf(15), winnings.get(4).getAmount());
        assertEquals(BigDecimal.valueOf(14), winnings.get(5).getAmount());
        assertEquals(BigDecimal.valueOf(13), winnings.get(6).getAmount());
        assertEquals(BigDecimal.valueOf(12), winnings.get(7).getAmount());
        assertEquals(BigDecimal.valueOf(11), winnings.get(8).getAmount());
        assertEquals(BigDecimal.valueOf(10), winnings.get(9).getAmount());
    }
}
