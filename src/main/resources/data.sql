-- Insert data into AccountView table
INSERT INTO account_view (entity_id,entity_name, account_number, name, state) VALUES (1,'Organization', '12345678', 'Savings Account', 'OPEN');
INSERT INTO account_view (entity_id, entity_name,account_number, name, state) VALUES (1,'Organization' ,'87654321', 'Investment Account', 'CLOSED');

-- Insert data into AssetView table
INSERT INTO asset_view (name) VALUES ('Fiat Currency');
INSERT INTO asset_view (name) VALUES ('Crypto');
INSERT INTO asset_view (name) VALUES ('Stock');
INSERT INTO asset_view (name) VALUES ('Bond');

-- Insert data into WalletView table
INSERT INTO wallet_view (name, account_id, asset_id, balance) VALUES ('Savings Wallet', 1, 1, 1000.00);
INSERT INTO wallet_view (name, account_id, asset_id, balance) VALUES ('Checking Wallet', 1, 2, 0.5);
INSERT INTO wallet_view (name, account_id, asset_id, balance) VALUES ('Investment Wallet', 2, 3, 500.00);
INSERT INTO wallet_view (name, account_id, asset_id, balance) VALUES ('Travel Wallet', 2, 4, 1000.00);

-- Insert data into MovementView table
INSERT INTO movement_view (source_wallet_id, destination_wallet_id, amount, state) VALUES (1, 2, 100.00, 'PENDING');
INSERT INTO movement_view (source_wallet_id, destination_wallet_id, amount, state) VALUES (3, 4, 200.00, 'PENDING');

-- Insert data into HistoricalBalanceView table
INSERT INTO historical_balance_view (wallet_id, balance, timestamp)
VALUES (1, 1000.00, '2022-01-01 00:00:00'),
       (2, 0.5, '2022-01-01 00:00:00'),
       (3, 500.00, '2022-01-01 00:00:00');

