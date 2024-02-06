package org.codancer.tx.service;

import org.springframework.stereotype.Component;

public interface BookService {
    void buyBook(Integer bookId, Integer userId);
}
