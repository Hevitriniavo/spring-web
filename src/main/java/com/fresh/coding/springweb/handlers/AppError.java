package com.fresh.coding.springweb.handlers;

import java.time.LocalDate;

public record AppError<T>(T messages, LocalDate date, Integer status) {
}
