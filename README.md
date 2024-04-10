# Ledger Query Service

The Ledger Query Service oversees read operations within the ledger system, facilitating access to historical balances and synchronizing Kafka command events with query tables.

## Table Structures

Here are the main tables used in the ledger system:

### Account View Table (`account_view`)

| Column Name       | Data Type    | Constraints                           | Description                                  |
|-------------------|--------------|---------------------------------------|----------------------------------------------|
| `id`              | BIGINT       | PRIMARY KEY                           | Primary key of the account view.             |
| `account_number`  | VARCHAR(255) |                                       | Account number.                              |
| `entity_id`       | BIGINT       |                                       | Associated entity ID.                        |
| `entity_name`     | VARCHAR(255) |                                       | Name of the associated entity.               |
| `name`            | VARCHAR(255) |                                       | Name of the account.                         |
| `state`           | VARCHAR(255) |                                       | State of the account (e.g., OPEN, CLOSED).   |

### Asset View Table (`asset_view`)

| Column Name  | Data Type    | Constraints                   | Description                     |
|--------------|--------------|-------------------------------|---------------------------------|
| `id`         | BIGINT       | PRIMARY KEY                   | Primary key of the asset view.  |
| `name`       | VARCHAR(255) |                               | Name of the asset.              |

### Entity View Table (`entity_view`)

| Column Name  | Data Type    | Constraints                   | Description                     |
|--------------|--------------|-------------------------------|---------------------------------|
| `id`         | BIGINT       | PRIMARY KEY                   | Primary key of the entity view. |
| `name`       | VARCHAR(255) |                               | Name of the entity.             |

### Historical Balance View Table (`historical_balance_view`)

| Column Name  | Data Type    | Constraints                           | Description                             |
|--------------|--------------|---------------------------------------|-----------------------------------------|
| `id`         | BIGINT       | PRIMARY KEY                           | Primary key of the historical balance view. |
| `wallet_id`  | BIGINT       |                                       | Associated wallet ID.                   |
| `balance`    | DOUBLE       |                                       | Balance amount at a specific timestamp.|
| `timestamp`  | VARCHAR(255) |                                       | Timestamp of the historical balance.   |

### Movement View Table (`movement_view`)

| Column Name             | Data Type    | Constraints                          | Description                              |
|-------------------------|--------------|--------------------------------------|------------------------------------------|
| `id`                    | BIGINT       | PRIMARY KEY                          | Primary key of the movement view.        |
| `source_wallet_id`      | BIGINT       |                                      | Source wallet ID.                       |
| `destination_wallet_id` | BIGINT       |                                      | Destination wallet ID.                  |
| `amount`                | DOUBLE       |                                      | Amount of the movement.                  |
| `timestamp`             | VARCHAR(255) |                                      | Timestamp of the movement.               |
| `state`                 | VARCHAR(255) |                                      | State of the movement (e.g., PENDING, CLEARED). |

### Wallet View Table (`wallet_view`)

| Column Name  | Data Type    | Constraints                           | Description                               |
|--------------|--------------|---------------------------------------|-------------------------------------------|
| `id`         | BIGINT       | PRIMARY KEY                           | Primary key of the wallet view.           |
| `name`       | VARCHAR(255) |                                       | Name of the wallet.                       |
| `balance`    | DOUBLE       |                                       | Current balance of the wallet.            |
| `account_id` | BIGINT       |                                       | Associated account ID.                    |
| `asset_id`   | BIGINT       |                                       | Associated asset ID.                      |

## Endpoint Description

### Historical Balance of Wallet

- **Endpoint**: `http://localhost:8081/ledger/historicalBalances/{walletId}?timstamp=` (GET)
- **Description**: Fetches historical balances of a wallet based on the provided `walletId` and timestamp. If the `timestamp` parameter is null, it retrieves records by `walletId` only. If a `timestamp` is provided, it fetches records by both `walletId` and `timestamp`. This endpoint retrieves data from the `historical_balance_view` table.
-  - **Example curl command**:
```bash
curl --location --request PUT 'http://localhost:8081/ledger/historicalBalances/1?timestamp=2024-04-10T09:16:47.403609600'
```

## Assumptions

- With the help of Dockerfile and Kubernetes deployment file (ledger-query-service-deployment.yaml), the Ledger Query Service can be deployed in a Kubernetes cluster. The Dockerfile is used to build a Docker image containing the service, while the Kubernetes deployment file is used to define how the service should be deployed and managed within the Kubernetes environment.
- - Development of the Ledger Command Service was performed on a local machine where Kafka was installed and configured. Hence, it is assumed that Kafka is installed and available on the server where this service will be tested. The Ledger Query Service relies on Kafka for asynchronous event publication, and hence Kafka must be set up and properly configured for testing purposes.

