CREATE TABLE IF NOT EXISTS currency_rate (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             from_currency VARCHAR(3),
                                             to_currency VARCHAR(3),
                                             rate DECIMAL(15, 9)
);