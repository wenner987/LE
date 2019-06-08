import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper private constructor(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "LE", null, 1) {
    init {
        instance = this
    }

    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context) = instance ?: MyDatabaseOpenHelper(ctx.applicationContext)
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable("Users", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "name" to TEXT,
            "password" to TEXT)
        db.insert("Users",
            "id" to 0,
            "name" to "233",
            "password" to "333"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("Users", true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(this)