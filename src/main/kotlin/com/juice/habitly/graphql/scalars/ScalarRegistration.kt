package com.juice.habitly.graphql.scalars

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsRuntimeWiring
import graphql.scalars.ExtendedScalars
import graphql.schema.idl.RuntimeWiring

@DgsComponent
class ScalarRegistration {

    @DgsRuntimeWiring
    fun addScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder {
        return builder.scalar(ExtendedScalars.GraphQLLong)
    }
}