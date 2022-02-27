package com.graphqljava.tutorial.bookdetails;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.execution.ExecutionContext;
import graphql.execution.instrumentation.DeferredFieldInstrumentationContext;
import graphql.execution.instrumentation.DocumentAndVariables;
import graphql.execution.instrumentation.ExecutionStrategyInstrumentationContext;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.parameters.InstrumentationDeferredFieldParameters;
import graphql.execution.instrumentation.parameters.InstrumentationExecuteOperationParameters;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionStrategyParameters;
import graphql.execution.instrumentation.parameters.InstrumentationFieldCompleteParameters;
import graphql.execution.instrumentation.parameters.InstrumentationFieldFetchParameters;
import graphql.execution.instrumentation.parameters.InstrumentationFieldParameters;
import graphql.execution.instrumentation.parameters.InstrumentationValidationParameters;
import graphql.language.Document;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class InstrumentationProvider extends SimpleInstrumentation {

    @Override
    public InstrumentationContext<List<ValidationError>> beginValidation(InstrumentationValidationParameters parameters) {
        System.out.println("Instrument :: beginValidation");
        return super.beginValidation(parameters);
//        throw new AbortExecutionException("Abort at beginValidation");
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters parameters) {
        System.out.println("Instrument :: beginExecution");
        return super.beginExecution(parameters);
    }

    @Override
    public ExecutionInput instrumentExecutionInput(ExecutionInput executionInput, InstrumentationExecutionParameters parameters) {
        return super.instrumentExecutionInput(executionInput, parameters);
    }

    @Override
    public InstrumentationContext<Document> beginParse(InstrumentationExecutionParameters parameters) {
        System.out.println("Instrument :: beginParse");
        return super.beginParse(parameters);
    }

    @Override
    public ExecutionStrategyInstrumentationContext beginExecutionStrategy(InstrumentationExecutionStrategyParameters parameters) {
        System.out.println("Instrument :: beginExecutionStrategy");
        return super.beginExecutionStrategy(parameters);
    }

    @Override
    public DeferredFieldInstrumentationContext beginDeferredField(InstrumentationDeferredFieldParameters parameters) {
        System.out.println("Instrument :: beginDeferredField");
        return super.beginDeferredField(parameters);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginExecuteOperation(InstrumentationExecuteOperationParameters parameters) {
        System.out.println("Instrument :: beginExecuteOperation");
        return super.beginExecuteOperation(parameters);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginField(InstrumentationFieldParameters parameters) {
        System.out.println("Instrument :: beginField");
//        System.out.println(" - snapId: " + parameters.getExecutionStepInfo().getArgument("snapId"));
        return super.beginField(parameters);
    }

    @Override
    public InstrumentationContext<Object> beginFieldFetch(InstrumentationFieldFetchParameters parameters) {
        System.out.println("Instrument :: beginFieldFetch");
        return super.beginFieldFetch(parameters);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginFieldComplete(InstrumentationFieldCompleteParameters parameters) {
        System.out.println("Instrument :: beginFieldComplete");
        return super.beginFieldComplete(parameters);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginFieldListComplete(InstrumentationFieldCompleteParameters parameters) {
        System.out.println("Instrument :: beginFieldListComplete");
        return super.beginFieldListComplete(parameters);
    }

    @Override
    public GraphQLSchema instrumentSchema(GraphQLSchema schema, InstrumentationExecutionParameters parameters) {
        System.out.println("Instrument :: instrumentSchema");
        return super.instrumentSchema(schema, parameters);
    }

    @Override
    public ExecutionContext instrumentExecutionContext(ExecutionContext executionContext, InstrumentationExecutionParameters parameters) {
        System.out.println("Instrument :: instrumentExecutionContext");
        return super.instrumentExecutionContext(executionContext, parameters);
    }

    @Override
    public DocumentAndVariables instrumentDocumentAndVariables(DocumentAndVariables documentAndVariables, InstrumentationExecutionParameters parameters) {
        System.out.println("Instrument :: instrumentDocumentAndVariables");
        return super.instrumentDocumentAndVariables(documentAndVariables, parameters);
    }

    @Override
    public DataFetcher<?> instrumentDataFetcher(DataFetcher<?> dataFetcher, InstrumentationFieldFetchParameters parameters) {
        System.out.println("Instrument :: instrumentDataFetcher");
        return super.instrumentDataFetcher(dataFetcher, parameters);
    }

    @Override
    public CompletableFuture<ExecutionResult> instrumentExecutionResult(ExecutionResult executionResult, InstrumentationExecutionParameters parameters) {
        System.out.println("Instrument::instrumentExecutionResult");
        return super.instrumentExecutionResult(executionResult, parameters);
    }
}
