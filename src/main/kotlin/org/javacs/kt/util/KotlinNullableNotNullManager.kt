/*
 * Source: https://github.com/JetBrains/kotlin-netbeans/blob/master/src/main/java/org/jetbrains/kotlin/model/KotlinNullableNotNullManager.kt
 * Licensed under http://www.apache.org/licenses/LICENSE-2.0
 */
package org.javacs.kt.util

import com.intellij.codeInsight.NullabilityAnnotationInfo
import com.intellij.openapi.project.Project
import com.intellij.codeInsight.NullableNotNullManager
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiModifierListOwner

class KotlinNullableNotNullManager(project: Project): NullableNotNullManager(project) {

	override fun setDefaultNullable(p0: String) {
		this.defaultNullable = p0
	}

	override fun getNullables(): MutableList<String> {
		return nullables
	}

	override fun setInstrumentedNotNulls(p0: MutableList<String>) {
		this.instrumentedNotNulls = p0
	}

	override fun getInstrumentedNotNulls(): MutableList<String> {
		return this.instrumentedNotNulls
	}

	override fun isJsr305Default(p0: PsiAnnotation, p1: Array<out PsiAnnotation.TargetType>): NullabilityAnnotationInfo? {
		return null
	}

	override fun setNullables(vararg p0: String?) {
		for (p in p0)
			if(p != null)
				this.nullables.add(p)
	}

	override fun getDefaultNotNull(): String {
		return this.defaultNotNull
	}

	override fun getNotNulls(): MutableList<String> {

	}

	override fun getDefaultNullable(): String {
		return this.defaultNullable
	}

	override fun setDefaultNotNull(p0: String) {
		this.defaultNotNull = p0
	}

	override fun setNotNulls(vararg p0: String?) {
		for (p in p0)
			if(p != null)
				this.notNulls.add(p)
	}

	init {
		setNotNulls("NotNull")
		setNullables("Nullable")
	}

	override fun hasHardcodedContracts(element: PsiElement) = false

	override fun isNotNull(owner: PsiModifierListOwner, checkBases: Boolean): Boolean {
		val notNullAnnotations = notNulls.toSet()
		return owner.modifierList?.annotations?.any { annotation ->
			annotation.qualifiedName in notNullAnnotations
		} ?: false
	}

	override fun isNullable(owner: PsiModifierListOwner, checkBases: Boolean) = !isNotNull(owner, checkBases)
}
