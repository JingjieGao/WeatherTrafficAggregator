# GET /api/combined_service/

## Description
Delete entity in the database with passed in id

## Param
* `locationId` - id of entity to delete from the database
    * Example: `api/combined_service/31`

## Success Response:
    * **Status Code:** 200
    * **Content:**

```json
{
    "message":"Location 31 deleted successfully."
}