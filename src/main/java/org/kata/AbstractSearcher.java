package org.kata;

import java.util.List;

abstract class AbstractSearcher {

    abstract List<Result> findCoordinates(String[] rows, String word);
}
