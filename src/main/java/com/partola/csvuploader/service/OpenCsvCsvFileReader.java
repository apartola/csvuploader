package com.partola.csvuploader.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class OpenCsvCsvFileReader<T> implements CsvFileReader<T> {
	
	@Override
	public boolean checkIsCsv(File file) {
		System.out.println("checking csv");
		return true;
	}
	
	@Override
	public boolean checkHeaders(File file, Class<T> type) {
		try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
			final String[] header = csvReader.readNextSilently();
			final List<String> headersList = Arrays.stream(header)
					.map(String::toLowerCase)
					.map(String::trim)
					.collect(Collectors.toList());
			final Field[] declaredFields = type.getDeclaredFields();
			final boolean result = Arrays.stream(declaredFields)
					.filter(field -> field.getAnnotation(CsvBindByName.class) != null)
					.map(Field::getName)
					.map(String::toLowerCase)
					.allMatch(headersList::contains);
			final boolean resultDuplicating = headersList.stream()
					.noneMatch(name -> Arrays.stream(declaredFields)
							.filter(field -> field.getAnnotation(CsvBindByName.class) != null)
							.map(Field::getName)
							.filter(name::equalsIgnoreCase)
							.count() > 1);
			return result && resultDuplicating;
		} catch (IOException ioe) {
			System.out.println(ioe.getLocalizedMessage());
		}
		
		
		return true;
	}
	
	@Override
	public Observable<T> read(File file, Class<T> type) throws FileNotFoundException {
		System.out.println("reading a file");
		final CSVReader csvReader = new CSVReader(new FileReader(file));
		final CsvToBean<T> build = new CsvToBeanBuilder<T>(csvReader)
				.withType(type)
				.build();
		return Observable.fromStream(build.stream());
	}
}
