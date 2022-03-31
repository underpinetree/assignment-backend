package com.example.assignment.service

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.stereotype.Service
import java.io.FileReader
import java.io.InputStream
import java.io.InputStreamReader

@Service
final class CsvImportService {
    val csvMapper = CsvMapper().apply {
        registerModule(
            KotlinModule.Builder()
                .withReflectionCacheSize(512)
                .configure(KotlinFeature.NullToEmptyCollection, false)
                .configure(KotlinFeature.NullToEmptyMap, false)
                .configure(KotlinFeature.NullIsSameAsDefault, false)
                .configure(KotlinFeature.SingletonSupport, false)
                .configure(KotlinFeature.StrictNullChecks, false)
                .build()
        )
    }
    inline fun <reified T> readCsvFile(filePath: InputStream): List<T> {
        InputStreamReader(filePath).use { reader ->
            return csvMapper
                .readerFor(T::class.java)
                .with(CsvSchema.emptySchema().withHeader())
                .readValues<T>(reader)
                .readAll()
                .toList()
        }
    }
    inline fun <reified T> readCsvFile(filePath: String): List<T> {
        val csvSchema = CsvSchema.builder()
            .setSkipFirstDataRow(true)
            .addColumn("first")
            .addColumn("second")
            .addColumn("third")
            .build()
        FileReader(filePath).use { reader ->
            return csvMapper
                .readerFor(T::class.java)
                .with(csvSchema)
                .readValues<T>(reader)
                .readAll()
                .toList()
        }
    }
}
