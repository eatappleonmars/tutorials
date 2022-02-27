package com.graphqljava.tutorial.bookdetails;

import graphql.schema.DataFetcher;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

public class SnapshotDirective implements SchemaDirectiveWiring {
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> environment) {
        DataFetcher<?> originalDataFetcher = environment.getFieldDataFetcher();
        DataFetcher<?> modifiedDataFetcher = dataFetchingEnvironment -> {
            System.out.println("this is modified data fetcher");
            return originalDataFetcher.get(dataFetchingEnvironment);
        };

        GraphQLFieldDefinition fieldDefinition = environment.setFieldDataFetcher(modifiedDataFetcher);
        GraphQLArgument argument = environment.getDirective().getArgument("snapshotInput");

        return fieldDefinition.transform(builder -> builder.argument(
                GraphQLArgument.newArgument()
                        .name(argument.getName())
                        .type(argument.getType())
                        .defaultValue("")
        ));
    }
}
