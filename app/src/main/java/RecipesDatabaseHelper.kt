import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RecipeDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Recipes.db"
        private const val TABLE_RECIPES = "Recipes"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_DIFFICULTY = "difficulty"
        private const val COLUMN_TIME = "time"
        private const val COLUMN_SERVINGS = "servings"
        private const val COLUMN_INGREDIENT_ID = "ingredientId"
        private const val COLUMN_METHOD = "method"
        private const val COLUMN_NOTES = "notes"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_RECIPES_TABLE = ("CREATE TABLE IF NOT EXISTS $TABLE_RECIPES " +
                "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAME TEXT NOT NULL," +
                "$COLUMN_DESCRIPTION TEXT," +
                "$COLUMN_DIFFICULTY INTEGER," +
                "$COLUMN_TIME INTEGER," +
                "$COLUMN_SERVINGS INTEGER," +
                "$COLUMN_INGREDIENT_ID INTEGER," +
                "$COLUMN_METHOD TEXT," +
                "$COLUMN_NOTES TEXT,")
        db.execSQL(CREATE_RECIPES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_RECIPES")
        onCreate(db)
    }

    fun getAllRecipeDetails(): ArrayList<Recipe> {
        val recipeList = ArrayList<Recipe>()
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery("SELECT * FROM $TABLE_RECIPES", null)
        } catch (e: Exception) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_RECIPES")
            onCreate(db)
            return ArrayList()
        }

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
                val difficulty = cursor.getInt(cursor.getColumnIndex(COLUMN_DIFFICULTY))
                val time = cursor.getInt(cursor.getColumnIndex(COLUMN_TIME))
                val servings = cursor.getInt(cursor.getColumnIndex(COLUMN_SERVINGS))
                val ingredientId = cursor.getInt(cursor.getColumnIndex(COLUMN_INGREDIENT_ID))
                val method = cursor.getString(cursor.getColumnIndex(COLUMN_METHOD))
                val notes = cursor.getString(cursor.getColumnIndex(COLUMN_NOTES))

                val recipe = Recipe(id, name, description, difficulty, time, servings, ingredientId, method, notes)
                recipeList.add(recipe)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return recipeList
    }
}