import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
class RecipesDatabaseHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null) {
    companion object{
        private const val DATABASE_NAME = "recipes.db"
        private const val DATABASE_VERSION = "1"
        private const val TABLE_NAME = "Recipes"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "name"
        private const val COLUMN_CONTENT = "method"
    }
}