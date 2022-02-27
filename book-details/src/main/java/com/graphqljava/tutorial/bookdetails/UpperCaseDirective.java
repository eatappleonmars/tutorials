package com.graphqljava.tutorial.bookdetails;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetcherFactories;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLFieldsContainer;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

public class UpperCaseDirective implements SchemaDirectiveWiring {

    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
        System.out.println("Building UpperCaseDirective");

        replaceDataFetcher(env);

        return SchemaDirectiveWiring.super.onField(env);
    }

    private void replaceDataFetcher(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {

        DataFetcher originalFetcher = env.getFieldDataFetcher();

        // build a data fetcher that transforms the given value to uppercase
        DataFetcher dataFetcher = DataFetcherFactories.wrapDataFetcher(
                originalFetcher,
                ((dataFetchingEnvironment, value) -> {
                    if (value instanceof String) {
                        return ((String) value).toUpperCase();
                    }
                    return value;
                }));

        GraphQLFieldDefinition field = env.getElement();
        GraphQLFieldsContainer parentType = env.getFieldsContainer();

        env.getCodeRegistry().dataFetcher(parentType, field, dataFetcher);
    }
}
