package org.sergei.topten;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
public interface TopTenWinningsService {

    void reportWinnings(Winning winning);

    List<Winning> getTopTenWinningsDesc();

    List<Winning> getWinnings();

    int getWinningsCount();
}
