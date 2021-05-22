package org.sergei.topten;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei Visotsky
 */
public class TopTenWinningsServiceImpl implements TopTenWinningsService {

    private final List<Winning> winnings;

    public TopTenWinningsServiceImpl() {
        this.winnings = Collections.synchronizedList(new LinkedList<>());
    }

    @Override
    public void reportWinnings(Winning winning) {
        winnings.add(winning);
    }

    @Override
    public List<Winning> getTopTenWinningsDesc() {
        return winnings.stream()
                .sorted(Comparator.comparing(Winning::getAmount).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Winning> getWinnings() {
        return winnings;
    }

    @Override
    public int getWinningsCount() {
        return winnings.size();
    }
}
